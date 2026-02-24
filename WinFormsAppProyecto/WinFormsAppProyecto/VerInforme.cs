using Controladores;
using Modelos;
using QuestPDF.Fluent;
using QuestPDF.Infrastructure;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formularios
{
    public partial class VerInforme : Form
    {
        private List<Gasto> _gastos;
        private int _idPiso;
        public VerInforme(int idPiso)
        {
            InitializeComponent();
            _idPiso = idPiso;
            CargarDatos();
        }

        private async void CargarDatos()
        {
            try
            {
                var controlador = new GastoControlador(); var todos = await controlador.getAll();
                // Filtrar por piso.id
                _gastos = todos.Where(g => g.piso != null && g.piso.id == _idPiso).ToList();
                if (_gastos.Count == 0)
                {
                    MessageBox.Show("Este piso no tiene gastos registrados.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error cargando datos:\n" + ex.Message);
            }
        }

        private void btnDescargar_Click(object sender, EventArgs e)
        {
            if (_gastos == null || _gastos.Count == 0)
            {
                MessageBox.Show("No hay datos para generar el informe.");
                return;
            }

            try
            {
                string ruta = Path.Combine(
                    Environment.GetFolderPath(Environment.SpecialFolder.Desktop),
                    "InformeGastos.pdf"
                );

                var doc = new InformeGastosDoc { Gastos = _gastos };
                doc.GeneratePdf(ruta);

                MessageBox.Show("Informe generado correctamente en:\n" + ruta);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error generando informe:\n" + ex.Message);
            }
        }
    }


    // ===============================
    // DOCUMENTO PDF
    // ===============================

    public class InformeGastosDoc : IDocument
    {
        public List<Gasto> Gastos { get; set; }

        public DocumentMetadata GetMetadata() => new DocumentMetadata();

        public void Compose(IDocumentContainer container)
        {
            var plt = new ScottPlot.Plot();

            // datos
            double[] valores = Gastos.Select(g => g.valor).ToArray();
            string[] conceptos = Gastos.Select(g => g.concepto).ToArray();

            // barras
            var bars = plt.Add.Bars(valores);


            // etiquetas del eje X (API correcta de 5.1.57)
            double[] posiciones = Enumerable.Range(0, conceptos.Length).Select(i => (double)i).ToArray();
            plt.Axes.Bottom.TickGenerator = new ScottPlot.TickGenerators.NumericManual(posiciones, conceptos);

            // título
            plt.Title("Gastos por concepto");

            // guardar imagen
            string rutaGrafico = Path.GetTempFileName() + ".png";
            plt.SavePng(rutaGrafico, 600, 400);

            double total = Gastos.Sum(g => g.valor);


            // 2) Crear PDF con QuestPDF
            container.Page(page =>
            {
                page.Margin(30);

                page.Header()
                    .Text("Informe de Gastos")
                    .FontSize(20)
                    .Bold();

                page.Content().Column(col =>
                {
                    col.Item().Image(rutaGrafico);
                    col.Item().PaddingVertical(20);

                    col.Item().Table(table =>
                    {
                        table.ColumnsDefinition(columns =>
                        {
                            columns.RelativeColumn();
                            columns.RelativeColumn();
                        });

                        table.Header(header =>
                        {
                            header.Cell().Text("Concepto").Bold();
                            header.Cell().Text("Valor").Bold();
                        });

                        foreach (var g in Gastos)
                        {
                            table.Cell().Text(g.concepto);
                            table.Cell().Text(g.valor.ToString("0.00"));
                        }
                    });

                    // ===== TOTAL =====
                    double total = Gastos.Sum(g => g.valor);

                    col.Item().PaddingVertical(10);

                    col.Item().Text($"TOTAL: {total:0.00} €")
                        .FontSize(14)
                        .Bold()
                        .AlignRight();
                });
            });
        }
    }
}
