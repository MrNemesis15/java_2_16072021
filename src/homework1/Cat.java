package homework1;

public class Cat implements RunJumpable {
    String name;
    int run_dist;
    int jump_height;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean run(Treadmill t) {
        if (run_dist > t.len) {
            System.out.println (name + " успешно пробежал" + t.len + " метров");
            if (run_dist < t.len) {
                System.out.println ("Не смог пробежать");

            }

        }

        return false;
    }

    @Override
    public boolean jump(Wall l) {
        if (jump_height > l.h) {
            System.out.println (name + " перепрыгнул стену" + l.h + " метров");
            if (jump_height < l.h) {
                System.out.println ("Не смог перепрыгнуть");
            }
        }
        return false;
    }
}