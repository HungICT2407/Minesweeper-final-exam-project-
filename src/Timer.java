import java.awt.*;

public class Timer {
    private int Loop_time = 0;
    private int Display_time = 0;

    public void Loop_time_setter(int x) {
        Loop_time = Loop_time + x;
    }

    public int Loop_time_getter() {
        return Loop_time;
    }

    public void Display_time_setter(int x) {
        Display_time = Display_time + x;
    }

    public int Display_time_getter() {
        return Display_time;
    }

    public void Screen_time(int x, int y) {
        StdDraw.setPenColor(StdDraw.WHITE);
        Font Font_2 = new Font("Times new roman", Font.BOLD, 15);
        StdDraw.setFont(Font_2);
        StdDraw.text(x, y, "TIME: " + Display_time);
    }
}
