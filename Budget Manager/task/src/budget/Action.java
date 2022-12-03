package budget;

public class Action {
    private final String name;
    private final Runnable runnable;
    private Menu menu;
    private static final Runnable blankRunnable = () -> {
    };

    public Action(String name) {
        this(name, blankRunnable);
    }

    public Action(String name, Runnable runnable) {
        this.name = name;
        this.runnable = runnable;
    }

    public void execute(boolean displayMenuAgain) {
        this.runnable.run();
        if (!this.runnable.equals(blankRunnable) && displayMenuAgain) {
            this.menu.display();
        }
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    public String getName() {
        return this.name;
    }

}
