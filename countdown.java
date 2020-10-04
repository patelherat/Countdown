package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class countdown {

    static List<Character> list_operands = new ArrayList<>();
    static Random r = new Random();
    private static int[] random_number = new int[]{3, 9, 4, 7, 6, 9, 9, 8, 8, 2, 9, 8, 2, 4, 7, 8, 4, 9, 1, 1, 8, 8, 1, 8, 1, 2, 7, 6, 9, 6, 6, 3, 7, 3, 5, 4, 3, 7, 6, 3, 2, 7, 6, 3, 9, 1, 8, 1, 1, 2, 5, 2, 2, 6, 6, 7, 3, 5, 8, 2, 9, 2, 7, 4, 1, 1, 6, 1, 6, 2, 1, 7, 8, 5, 3, 1, 2, 6, 6, 5, 6, 1, 5, 4, 3, 8, 8, 6, 9, 9, 8, 2, 5, 4, 8, 6, 4, 6, 1, 1};

    static int random_target = 1039;
    //random_target = 1039;

    public void swap(int swapRandom1, int swapRandom2){
        int temp;
        temp = random_number[swapRandom1];
        random_number[swapRandom1] = random_number[swapRandom2];
        random_number[swapRandom2] = temp;
    }

    public void change(int otor, int orand){
        char operand;//+-*/
        if(orand == 0)
            operand = '+';
        else if(orand == 1)
            operand = '-';
        else if(orand == 2)
            operand = '*';
        else
            operand = '/';
        list_operands.set(otor, operand);
    }

    public static void main(String[] args) {
        countdown cd = new countdown();

        double target_achieved = random_number[0];
        int random_operand;
        for (int i=1; i<100; i++){
            random_operand = r.nextInt(4);
            if(random_operand == 0) {
                list_operands.add('+');
                target_achieved = target_achieved + random_number[i];
            }
            else if (random_operand == 1) {
                list_operands.add('-');
                target_achieved = target_achieved - random_number[i];
            }
            else if(random_operand == 2) {
                list_operands.add('*');
                target_achieved = target_achieved * random_number[i];
            }
            else {
                list_operands.add('/');
                target_achieved = target_achieved / random_number[i];
            }
        }

        double distance_from_target, best = Integer.MAX_VALUE;
        distance_from_target = random_target - target_achieved;
        if(best > distance_from_target)
            best = distance_from_target;
        System.out.println("distance is " + distance_from_target);
        if(Math.abs(distance_from_target) < 20)
            System.exit(0);
        double best1 = best;

        int swap_random1, swap_random2, constant=0;

        while(true) {
            swap_random1 = r.nextInt(100);
            swap_random2 = r.nextInt(100);

            int swapOrChange, otor, orand;
            swapOrChange = r.nextInt(2);
            otor = r.nextInt(99);
            orand = r.nextInt(4);
            if (swapOrChange == 0)
                cd.swap(swap_random1, swap_random2);
            else
                cd.change(otor, orand);

            target_achieved = random_number[0];
            for (int i = 1; i < 100; i++) {
                char ch = list_operands.get(i - 1);
                if (ch == '+')
                    target_achieved = target_achieved + random_number[i];
                else if (ch == '-')
                    target_achieved = target_achieved - random_number[i];
                else if (ch == '*')
                    target_achieved = target_achieved * random_number[i];
                else
                    target_achieved = target_achieved / random_number[i];
            }

            distance_from_target = random_target - target_achieved;
            if (best > Math.abs(distance_from_target))
                best = distance_from_target;

            if(Math.abs(distance_from_target) < 3) {
                System.out.println("dist is " + distance_from_target);
                break;
            }

            if((int)best1 == (int)best) {
                constant++;
                if(constant == 5){
                    for (int i = random_number.length - 1; i > 0; i--)
                    {
                        int index = r.nextInt(i + 1);
                        int a = random_number[index];
                        random_number[index] = random_number[i];
                        random_number[i] = a;
                    }
                }
            }
            else {
                System.out.println("Distance is " + best);
                constant = 0;
            }
        }
    }
}
