public class Effect {

    Coordinate C = new Coordinate();

    public Effect() {
        Effect_screen();
    }

    private void Effect_screen() {
        for (int x = 50; x <= 950; x = x + 100) {

            for (int i = 50; i <= 850; i = i + 100) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(x, i, 50);
            }

            for (int i = 0; i <= 45; i++) {
                for (int y = 50; y <= 850; y = y + 100) {
                    C.Special_square(x, y, i);
                }
                StdDraw.show();
                StdDraw.pause(1);
            }
        }
    }
}
