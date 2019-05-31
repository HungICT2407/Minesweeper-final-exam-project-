import java.awt.*;

public class Experiment {
    public static void main(String[] args) {
        Animation A = new Animation();

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        int x = 75;
        int y = 675;
        int Counter = 0;

        while (true) {

            Counter++;

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(500, 500, 500);

            HIT H = new HIT(1, 0, 0, true);
            for (int i = 25; i <= 975; i += 25) {
                for (int j = 325; j <= 675; j += 25) {
                    if ((25 < i && i < 975) && (325 < j && j < 675)) {
                        continue;
                    } else {
                        HIT HC = new HIT(3, i, j, true);
                    }
                }
            }
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_AI_4 = new Font("Times new roman", Font.ITALIC, 15);
            StdDraw.setFont(Font_AI_4);
            StdDraw.text(500, 300, "This is a copyright...");

            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
