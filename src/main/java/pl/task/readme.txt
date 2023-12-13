Wyjaśnienie poszczególnych składowych kodu:

Task (Model): Reprezentuje encję bazy danych, w tym przypadku zadanie. Oznacza ją adnotacja @Entity.

TaskRepository (Repozytorium): Interfejs rozszerzający JpaRepository dostarcza podstawowe operacje na bazie danych związane z encją Task.

TaskService (Serwis): Klasa zawiera logikę biznesową, obsługującą operacje na zadaniach, wykorzystując TaskRepository.

TaskController (Kontroler): Klasa obsługująca zapytania HTTP związane z zadaniami. Adnotacja @RestController oznacza,
że metody kontrolera zwracają dane, a nie widoki HTML. Adnotacja @RequestMapping("/api/tasks") określa ścieżkę do kontrolera.