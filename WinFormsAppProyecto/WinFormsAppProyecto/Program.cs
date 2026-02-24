using QuestPDF.Infrastructure;

namespace WinFormsAppProyecto
{
    internal static class Program
    {
        [STAThread]
        static void Main()
        {
            // Declarar licencia de QuestPDF (obligatorio desde 2024)
            QuestPDF.Settings.License = LicenseType.Community;

            ApplicationConfiguration.Initialize();
            Application.Run(new FormLogs());
        }
    }
}
