package main;


public class PriceSpelledOutApp {

    private static long numberFromUser;
    private static int billions;
    private static int millions;
    private static int thousands;
    private static int toThousand;

    public static int getBillions() {
        return billions;
    }
    public static int getMillions() {
        return millions;
    }
    public static int getThousands() {
        return thousands;
    }
    public static int getToThousand() {
        return toThousand;
    }


    private static final String[][] BUILDING_BLOCKS =
            {{"", "один ", "два ", "три ", "четыре ", "пять ", "шесть ","семь ", "восемь ", "девять "},
                    {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
                    {"", "одна ", "две ", "три ", "четыре ", "пять ", "шесть ","семь ", "восемь ", "девять "},
                    {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}};
    private static final String[] FROM_10_TO_19 = {"десять ", "одиннадцать ", "двенадцать ", "тринадцать ",
            "четырнадцать ", "пятнадцать ", "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать "};

    private static final String[][] LEVELS = {
            {"миллиард ", "миллион ","тысяча ",""},
            {"миллиардов ", "миллионов ","тысяч ",""},
            {"миллиарда ", "миллиона ","тысячи ",""}};

    public static long getNumberFromUser(IOService ioService) {
        String buffer = ioService.inputString();
        try {
            numberFromUser = Long.parseLong(buffer);
        } catch (Throwable e) {
            throw new NumberFormatException("Введенный текст не является числом");
        }
        return numberFromUser;
    }

    public static void getNumberBlocks(long numberFromUser) {
        billions = (int) (numberFromUser / 1_000_000_000);
        millions = (int) (numberFromUser - (billions * 1_000_000_000)) / 1_000_000;
        thousands = (int) (numberFromUser - (billions * 1_000_000_000) - (millions * 1_000_000)) / 1000;
        toThousand = (int) (numberFromUser % 1000);
    }

    public static String numberBlockToText(int numberBlock, int index) {
        int number = numberBlock;
        String text = "";
        int hundreds = number / 100;
        int decimal = (number - (hundreds * 100)) / 10;
        int units = number % 10;
        if (decimal == 1) {
            text = BUILDING_BLOCKS[3][hundreds] + FROM_10_TO_19[units];
        } else if (index == 2) {
            text = BUILDING_BLOCKS[3][hundreds] + BUILDING_BLOCKS[1][decimal] +
                    BUILDING_BLOCKS[index][units];
        } else {
            text = BUILDING_BLOCKS[3][hundreds] + BUILDING_BLOCKS[1][decimal] +
                    BUILDING_BLOCKS[0][units];
        }

        if (number != 0) {
            if (units == 1) {
                text = text + LEVELS[0][index];
            } else if (units > 1 && units < 5) {
                text = text + LEVELS[2][index];
            } else {
                text = text + LEVELS[1][index];
            }
        }

        if (index == 3) {
            if (units == 1) {
                text = text + Currency.RUB[0];
            } else if (units > 1 && units < 5) {
                text = text + Currency.RUB[1];
            } else {
                text = text + Currency.RUB[2];
            }
        }

        return text;
    }

    public static String numberToText(int billions, int millions, int thousands, int toThousand) {
        String numToText = numberBlockToText(billions, 0) + numberBlockToText(millions, 1) + numberBlockToText(thousands, 2)
                + numberBlockToText(toThousand, 3);
        return numToText;
    }

    public static void main(String[] args) {
        IOService ioService = new IOStreamsService(System.out, System.in);

        ioService.outputString("Введите число от 0 до 999 999 999 999");
        numberFromUser = getNumberFromUser(ioService);
        getNumberBlocks(numberFromUser);

        String numberToText = numberToText(billions, millions, thousands, toThousand);
        System.out.println(numberToText);
    }
}
