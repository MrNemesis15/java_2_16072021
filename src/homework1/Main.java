package homework1;
//Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
// Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//
// Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать),
// результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//
// Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
// Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill (1000);
        Wall wall = new Wall (6);

        RunJumpable[] rJ = {
                new Cat ("Barsik"),
                new Human ("Jack"),
                new Robot ("Altron")
        };
        for (int i = 0; i < rJ.length; i++) {
            rJ[i].jump (wall);
            rJ[i].run (treadmill);

        }
    }
}



