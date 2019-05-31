import java.awt.*;
import java.util.Random;

public class Display_2 {

    public Display_2(int i) {
        Display_content(i);
    }

    /* I. Global variable: */

    Game_back_end G = new Game_back_end();
    Game_back_end G2 = new Game_back_end();
    Coordinate C = new Coordinate();
    Animation A = new Animation();
    Timer T = new Timer();
    Random RD2 = new Random();
    Score SC = new Score();


    int Marked_flag_x[] = new int[10];
    int Marked_flag_y[] = new int[9];
    int Loop_time;
    int Reset = 0;
    int Reset_choice = 0;
    int Flag_number = 0;
    int Suggestion_effect = 0;
    int Opened_counter = 0;
    int Game_over_x;
    int Game_over_y;
    int Suggestion_counter = 0;
    int AI_counter = 0;
    int AI_thinking_counter = 0;
    int AI_Opened_counter = 0;
    int AI_x;
    int AI_y;
    int Offical_score = 0;
    int AI_total_score = 1000;
    int AI_time = 0;
    int Fight_start_count_down = 3;
    int Fight_start_check = 0;
    int AI_thinking_speed;
    int AI_mouse_position_x = -650;
    int AI_mouse_position_y = 450;
    int x_speed;
    int y_speed;
    int Division;
    int AI_bomb_opened_counter = 0;
    double Opened_bomb_possibility;
    int AI_over_x;
    int AI_over_y;
    int AI_bomb_choose_possibility;
    int AI_opened_nomine_counter = 0;

    boolean Marked_flag_check[][] = new boolean[10][9];
    boolean Reset_check = false; /* (?) Don't understand why have to initialize Reset_check. */
    boolean Opened_coordinate[][] = new boolean[10][9];
    boolean AI_opened_coordinate[][] = new boolean[10][9];
    boolean AI_marked_Flag[][] = new boolean[10][9];
    boolean Suggestion_check = false;
    boolean Suggestion_coordinate[][] = new boolean[10][9];
    boolean Hammer_check = true;
    boolean Flag_check = false;
    boolean X_check = false;
    boolean Game_over = false;
    boolean Score_board = false;
    boolean Menu_check = false;
    boolean Player_done = false;
    boolean AI_done = false;
    boolean Play_again_check_2;
    boolean AI_mouse_check = true;
    boolean AI_unopenable_check[][] = new boolean[10][9];
    boolean Lock_distance = false;
    boolean AI_bomb = false;
    boolean AI_bomb_check = false;

    /* II. Graphics: */

    private void Display_content(int Level) {

        Zoom_red_square Z = new Zoom_red_square(false);

        if (Level == 0) {
            AI_thinking_speed = 200;
            Division = 100;
            AI_bomb_choose_possibility = 7;
        }
        if (Level == 1) {
            AI_thinking_speed = 100;
            Division = 50;
            AI_bomb_choose_possibility = 6;
        }
        if (Level == 2) {
            AI_thinking_speed = 15;
            Division = 5;
            AI_bomb_choose_possibility = 0;
        }

        StdDraw.enableDoubleBuffering();

        while (Fight_start_check <= 139) {

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(-50, 500, 1050, 500);

            for (int x = -1100; x <= -200; x = x + 100) {
                for (int y = 0; y <= 800; y = y + 100) {
                    C.Square(x + 50, y + 50, 0);
                }
            }


            for (int x = 0; x <= 900; x = x + 100) {
                for (int y = 0; y <= 800; y = y + 100) {
                    C.Square(x + 50, y + 50, 0);
                }
            }

            T.Screen_time(120, 950);
            A.Torch(20, 950);
            A.Torch(220, 950);

            T.Screen_time(-980, 950);
            A.Torch(-1080, 950);
            A.Torch(-880, 950);
            A.Hammer(750, 950);
            A.Flag(860, 950);
            A.X(950, 950);
            A.Reset_button(500, 950);

            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_AI_4 = new Font("Times new roman", Font.BOLD, 30);
            StdDraw.setFont(Font_AI_4);
            StdDraw.text(-300, 950, "CHALLENGER");

            A.Dynamine(375, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_2 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_2);
            StdDraw.text(325, 950, "" + G.Mine_quantity);

            A.Dynamine(-725, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_3 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_3);
            StdDraw.text(-775, 950, "" + G2.Mine_quantity);

            A.Light_bult(670, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.setFont(Font_2);
            StdDraw.text(630, 950, "" + Suggestion_counter);

            if (Fight_start_count_down == 0) A.Fight(-50, 500);
            else {
                StdDraw.setPenColor(StdDraw.ORANGE);
                Font Font_count = new Font("Arial", Font.BOLD, 300);
                StdDraw.setFont(Font_count);
                StdDraw.text(-50, 500, "" + Fight_start_count_down);

            }

            Fight_start_check++;
            if (Fight_start_check % 35 == 0) Fight_start_count_down--;

            StdDraw.show();
            StdDraw.pause(20);
        }

        while (true) {

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(-50, 500, 1050, 500);

            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_AI_4 = new Font("Times new roman", Font.BOLD, 30);
            StdDraw.setFont(Font_AI_4);
            StdDraw.text(-300, 950, "CHALLENGER");

            /* AI: */

            AI_thinking_counter++;

            if (AI_done == false) AI_time = T.Display_time_getter();


            for (int x = -1100; x <= -200; x = x + 100)
                for (int y = 0; y <= 800; y = y + 100) {
                    C.Square(x + 50, y + 50, 0);
                }

            if (AI_mouse_check == true) {
                do {
                    AI_x = RD2.nextInt(10);
                    AI_y = RD2.nextInt(9);
                    if (AI_opened_coordinate[AI_x][AI_y] == false && AI_marked_Flag[AI_x][AI_y] == false) {
                        AI_mouse_check = false;
                        AI_unopenable_check[AI_x][AI_y] = true;
                        break;
                    }
                    if (AI_counter == 90) {
                        AI_done = true;
                        break;
                    }
                } while (true);
            }

            if (AI_thinking_counter % AI_thinking_speed == 0) {
                if (G2.Map[1 + AI_x][1 + AI_y] == false && AI_opened_coordinate[AI_x][AI_y] == false) {
                    AI_spread_algorithm(AI_x, AI_y);
                    AI_bomb_opened_counter++;
                } else if (G2.Map[1 + AI_x][1 + AI_y] == true && AI_marked_Flag[AI_x][AI_y] == false) {
                    if (AI_bomb_opened_counter % 3 == 0 && AI_bomb_check == false) {
                        Opened_bomb_possibility = RD2.nextInt(10);
                        if (Opened_bomb_possibility <= AI_bomb_choose_possibility) {
                            AI_bomb_check = true;
                            AI_over_x = AI_x * 100 - 1050;
                            AI_over_y = AI_y * 100 + 50;
                        }
                    } else {
                        AI_marked_Flag[AI_x][AI_y] = true;
                        AI_counter++;
                    }
                }
            }

            AI_total_score = 1000 + AI_Opened_counter * 50 - AI_time;

            for (int x = -1100; x <= -200; x = x + 100)
                for (int y = 0; y <= 800; y = y + 100)
                    if (AI_opened_coordinate[(x + 1100) / 100][y / 100] == true && AI_unopenable_check[(x + 1100) / 100][y / 100] == false) {

                        C.Square(50 + x, 50 + y, 2);

                        if (G2.Count[1 + (x + 1100) / 100][1 + y / 100] != 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            Font Font_2 = new Font("Times new roman", Font.BOLD, 30);
                            StdDraw.setFont(Font_2);
                            StdDraw.text(50 + x, 50 + y, "" + G2.Count[1 + (x + 1100) / 100][1 + y / 100]);
                        }
                    } else if (AI_marked_Flag[(x + 1100) / 100][y / 100] == true && AI_unopenable_check[(x + 1100) / 100][y / 100] == false) {
                        A.Flag(50 + x, 50 + y);
                    } else if ((x + 5 <= AI_mouse_position_x && AI_mouse_position_x <= x + 95) && (y + 5 <= AI_mouse_position_y && AI_mouse_position_y <= y + 95)) {
                        C.Square(50 + x, 50 + y, 1);
                    }

            if (Lock_distance == false) {
                x_speed = (((AI_x * 100) - 1050) - AI_mouse_position_x) / Division;
                y_speed = (((AI_y * 100) + 50) - AI_mouse_position_y) / Division;
                Lock_distance = true;
            }

            if (AI_mouse_check == false) {
                AI_mouse_position_x += x_speed;
                AI_mouse_position_y += y_speed;
            }

            if ((AI_x * 100) - 1050 == AI_mouse_position_x && (AI_y * 100) + 50 == AI_mouse_position_y) {
                Special_AI_spread_algorithm(AI_x, AI_y);
                AI_mouse_check = true;
                Lock_distance = false;
                if (AI_over_x == AI_mouse_position_x && AI_over_y == AI_mouse_position_y) AI_bomb = true;
                if (AI_opened_nomine_counter == 90 - G2.Mine_quantity) AI_done = true;
            }

            A.AI_mouse(AI_mouse_position_x, AI_mouse_position_y);

            /* III. Timer: */

            T.Loop_time_setter(10);
            Loop_time = T.Loop_time_getter();
            if (Loop_time % 600 == 0) {
                T.Display_time_setter(1);
            }

            /* IV. Mouse - coordinate updating:  */

            double x_mouse = StdDraw.mouseX();
            double y_mouse = StdDraw.mouseY();

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(500, 500, 500);
            if (StdDraw.isMousePressed()) {

                if ((475 <= x_mouse && x_mouse <= 525) && (925 <= y_mouse && y_mouse <= 975)) {
                    Reset_check = true;
                }

                if ((625 <= x_mouse && x_mouse <= 775) && (925 <= y_mouse && y_mouse <= 975)) {
                    Suggestion_check = true;
                    Hammer_check = false;
                    Flag_check = false;
                    X_check = false;
                }

                if ((725 <= x_mouse && x_mouse <= 775) && (925 <= y_mouse && y_mouse <= 975)) {
                    Hammer_check = true;
                    Suggestion_check = false;
                    Flag_check = false;
                    X_check = false;

                }

                if ((835 <= x_mouse && x_mouse <= 885) && (925 <= y_mouse && y_mouse <= 975)) {
                    Flag_check = true;
                    Suggestion_check = false;
                    Hammer_check = false;
                    X_check = false;
                }

                if ((925 <= x_mouse && x_mouse <= 975) && (925 <= y_mouse && y_mouse <= 975)) {
                    X_check = true;
                    Suggestion_check = false;
                    Hammer_check = false;
                    Flag_check = false;
                }

                if (Flag_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95) && Opened_coordinate[x / 100][y / 100] == false && Suggestion_coordinate[x / 100][y / 100] == false) {
                                if (Marked_flag_check[x / 100][y / 100] == false) {
                                    Marked_flag_x[x / 100] = x + 50;
                                    Marked_flag_y[y / 100] = y + 50;
                                    Marked_flag_check[x / 100][y / 100] = true;

                                    Flag_number++;
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (X_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {
                                if (Marked_flag_check[x / 100][y / 100] == true) {
                                    Marked_flag_check[x / 100][y / 100] = false;
                                    Flag_number--;
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (Hammer_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {

                                if (G.Map[1 + x / 100][1 + y / 100]) {
                                    Game_over = true;
                                    Game_over_x = x + 50;
                                    Game_over_y = y + 50;
                                }

                                if (G.Map[1 + x / 100][1 + y / 100] == false && Opened_coordinate[x / 100][y / 100] == false) {

                                    Spread_algorithm(x / 100, y / 100);

                                    Suggestion_coordinate[x / 100][y / 100] = false;
                                    Opened_coordinate[x / 100][y / 100] = true;

                                    if (Marked_flag_check[x / 100][y / 100] == true) {
                                        Marked_flag_check[x / 100][y / 100] = false;
                                        Flag_number--;
                                    }
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (Suggestion_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95) && Suggestion_coordinate[x / 100][y / 100] == false && Opened_coordinate[x / 100][y / 100] == false) {
                                Suggestion_coordinate[x / 100][y / 100] = true;
                                Suggestion_counter++;
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                }
            } else {
                for (int x = 0; x <= 900; x = x + 100)
                    for (int y = 0; y <= 800; y = y + 100) {
                        if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {
                            C.Square(x + 50, y + 50, 1);
                        } else C.Square(x + 50, y + 50, 0);
                    }
            }

            if (Reset_check == true) Reset++;

            for (int x = 0; x <= 9; x++)
                for (int y = 0; y <= 8; y++) {
                    if (Marked_flag_check[x][y] == true)
                        A.Flag(Marked_flag_x[x], Marked_flag_y[y]);

                    if (Opened_coordinate[x][y] == true) {

                        C.Square(x * 100 + 50, y * 100 + 50, 2);

                        if (G.Count[x + 1][y + 1] != 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            Font Font_2 = new Font("Times new roman", Font.BOLD, 30);
                            StdDraw.setFont(Font_2);
                            StdDraw.text(x * 100 + 50, y * 100 + 45, "" + G.Count[x + 1][y + 1]);
                        }
                    } else if (Suggestion_coordinate[x][y] == true) {
                        if (G.Map[x + 1][y + 1] == false) {
                            if (Suggestion_effect % 60 <= 30) A.Yes_sign(50 + x * 100, 50 + y * 100);
                            else StdDraw.setPenColor(StdDraw.BOOK_RED);
                        } else {
                            if (Suggestion_effect % 60 <= 30) A.No_sign(50 + x * 100, 50 + y * 100);
                            else StdDraw.setPenColor(StdDraw.BOOK_RED);
                        }
                    }
                }
            Suggestion_effect++;

            T.Screen_time(120, 950);
            A.Torch(20, 950);
            A.Torch(220, 950);

            T.Screen_time(-980, 950);
            A.Torch(-1080, 950);
            A.Torch(-880, 950);

            A.Dynamine(375, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_2 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_2);
            StdDraw.text(325, 950, "" + G.Mine_quantity);

            A.Dynamine(-725, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_3 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_3);
            StdDraw.text(-775, 950, "" + G2.Mine_quantity);

            A.Light_bult(670, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.setFont(Font_2);
            StdDraw.text(630, 950, "" + Suggestion_counter);

            if (Suggestion_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(650, 950, 50, 50);
            }

            if (Hammer_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(750, 950, 50, 50);
            }
            A.Hammer(750, 950);

            if (Flag_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(850, 950, 50, 50);
            }
            A.Flag(860, 950);

            if (X_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(950, 950, 50, 50);
            }
            A.X(950, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_AI_3 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_AI_3);
            StdDraw.text(820, 950, "" + Flag_number);

            if (Reset == 1) {
                StdDraw.filledCircle(500, 950, 30);
            }

            A.Reset_button(500, 950);

            /* V. Reset screen: */

            if (Reset == 2) {
                while (true) {

                    double Reset_x_mouse = StdDraw.mouseX();
                    /* + Return x-coordinate of mouse.*/
                    double Reset_y_mouse = StdDraw.mouseY();
                    /* + Return y-coordinate of mouse. */

                    if (StdDraw.isMousePressed()) {

                        if ((250 <= Reset_x_mouse && Reset_x_mouse <= 450) && (430 <= Reset_y_mouse && Reset_y_mouse <= 510)) {
                            Reset_choice = 1;
                            break;
                        }

                        if ((550 <= Reset_x_mouse && Reset_x_mouse <= 750) && (430 <= Reset_y_mouse && Reset_y_mouse <= 510)) {
                            Reset_choice = 2;
                            break;
                        }
                    }

                    A.Reset_screen(500, 500);
                    A.Yes(350, 470);
                    A.No(650, 470);

                    StdDraw.show();
                    StdDraw.pause(10);
                }
            }
            if (Reset_choice == 1) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(350, 470, 99, 39);
                StdDraw.show();
                StdDraw.pause(10);
                A.Yes(350, 470);
                StdDraw.show();
                StdDraw.pause(10);
                break;
            }
            if (Reset_choice == 2) {

                Reset_choice = 0;
                Reset_check = false;
                Reset = 0;

                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(650, 470, 99, 39);
                StdDraw.show();
                StdDraw.pause(10);
                A.No(650, 470);
                StdDraw.show();
                StdDraw.pause(500);
                continue;
            }

            /* VI. Animation controlling: */

            if (Opened_counter == 90 - G.Mine_quantity || Game_over == true) {
                Score_board = true;
                break;
            }

            if (AI_done == true || AI_bomb == true) break;

            StdDraw.show();
            StdDraw.clear();
            StdDraw.pause(10);
        }

        if (AI_bomb) {
            for (int i = 0; i <= 24; i++) {
                A.Mine(AI_over_x, AI_over_y);
                A.AI_mouse(AI_over_x, AI_over_y);

                StdDraw.show();
                StdDraw.pause(10);
            }

            AI_total_score -= 1000;
        }

        if (AI_total_score < 0) AI_total_score = 0;

        if (Game_over) {
            for (int i = 0; i <= 24; i++) {
                A.Mine(Game_over_x, Game_over_y);

                StdDraw.show();
                StdDraw.pause(10);
            }
        } else StdDraw.pause(500);

        int Score_check = SC.Remaining_score(300 * Suggestion_counter + T.Display_time_getter()) + 50 * Opened_counter;
        if (Game_over) Score_check = Score_check - 1000;
        if (Score_check < 0) Offical_score = 0;
        else Offical_score = Score_check;

        if (Reset_choice != 1) {
            int Play_again_check_1 = 0;
            int Menu_check_1 = 0;

            while (Play_again_check_1 <= 10 && Menu_check_1 <= 10) {

                double Mouse_x = StdDraw.mouseX();
                double Mouse_y = StdDraw.mouseY();

                if (StdDraw.isMousePressed()) {
                    if ((575 <= Mouse_x && Mouse_x <= 925) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Play_again_check_2 = true;
                        Reset_choice = 1;

                    } else if ((75 <= Mouse_x && Mouse_x <= 425) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Menu_check = true;
                    }
                }

                if (Play_again_check_2) Play_again_check_1++;
                if (Menu_check) Menu_check_1++;
                if (Game_over)
                    A.Mine(Game_over_x, Game_over_y);

                if (AI_total_score > Offical_score) A.Tropy(-600, 480);
                StdDraw.setPenColor(StdDraw.ORANGE);
                Font Font_AI_2 = new Font("Times new roman", Font.BOLD, 300);
                StdDraw.setFont(Font_AI_2);
                StdDraw.text(-600, 500, "" + AI_total_score);

                if (AI_total_score < Offical_score) A.Tropy(500, 480);
                StdDraw.setPenColor(StdDraw.ORANGE);
                Font Font_6 = new Font("Times new roman", Font.BOLD, 300);
                StdDraw.setFont(Font_6);
                StdDraw.text(500, 500, "" + Offical_score);

                A.Menu(250, 150);
                if (1 <= Menu_check_1 && Menu_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(249, 149, 174, 48);
                }
                A.Play_again(750, 150);
                if (1 <= Play_again_check_1 && Play_again_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(749, 149, 174, 48);
                }

                StdDraw.show();
                StdDraw.pause(10);
            }
        }
    }

    public void Spread_algorithm(int x, int y) {

        Opened_coordinate[x][y] = true;
        Opened_counter++;

        if (G.Count[x + 1][y + 1] == 0) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (i != 0 || j != 0)
                        if (0 <= x + i && x + i <= 9 && 0 <= y + j && y + j <= 8)
                            if (Opened_coordinate[x + i][y + j] == false)
                                Spread_algorithm(x + i, y + j);
        }
    }

    public void Special_AI_spread_algorithm(int x, int y) {
        AI_unopenable_check[x][y] = false;

        if (G2.Count[x + 1][y + 1] == 0) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (i != 0 || j != 0)
                        if (0 <= x + i && x + i <= 9 && 0 <= y + j && y + j <= 8)
                            if (AI_opened_coordinate[x + i][y + j] == true && AI_unopenable_check[x + i][y + j] == true)
                                Special_AI_spread_algorithm(x + i, y + j);
        }
    }

    public void AI_spread_algorithm(int x, int y) {

        AI_opened_coordinate[x][y] = true;
        AI_Opened_counter++;
        AI_counter++;
        AI_unopenable_check[x][y] = true;
        AI_opened_nomine_counter++;

        if (G2.Count[x + 1][y + 1] == 0) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (i != 0 || j != 0)
                        if (0 <= x + i && x + i <= 9 && 0 <= y + j && y + j <= 8)
                            if (AI_opened_coordinate[x + i][y + j] == false)
                                AI_spread_algorithm(x + i, y + j);
        }
    }
}
