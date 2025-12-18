using Formularios;

namespace WinFormsAppProyecto
{
    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            ApplicationConfiguration.Initialize();
            List<string> nombres = new List<string>
{
    "Ana",
    "Luis",
    "Carlos",
    "María",
    "José",
    "Lucía",
    "Pedro",
    "Sofía",
    "Miguel",
    "Laura",
    "Javier",
    "Paula",
    "Andrés",
    "Carmen",
    "Diego",
    "Elena",
    "Fernando",
    "Isabel",
    "Raúl",
    "Patricia",
    "Daniel",
    "Natalia",
    "Hugo",
    "Verónica",
    "Alejandro",
    "Marta",
    "Sergio",
    "Claudia",
    "Alberto",
    "Silvia",
    "Rubén",
    "Beatriz",
    "Iván",
    "Rocío",
    "Adrián",
    "Lorena",
    "Óscar",
    "Noelia",
    "Marcos",
    "Cristina",
    "David",
    "Esther",
    "Pablo",
    "Irene",
    "Álvaro",
    "Sara",
    "Manuel",
    "Nerea",
    "Joaquín",
    "Alicia"
};

            Application.Run(new Formpruebas(nombres));
        }
    }
}