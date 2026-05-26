public class Sample5 
{
    public static void main(String[] args)
    {
        int age = 20;
        boolean hasTicket = true;
        boolean isMember = false;
        boolean hasCoupon = true;
        boolean hasStudentCard = true;
        int eventType = 2;
        int seatType = 3;
        int money = 4200;

        if (!hasTicket) {
            System.out.println("チケットがありません。\n入場できません。");
        } else if (age < 13) {
            System.out.println("年齢制限により入場できません。");
        } else {
            System.out.println("入場できます。");

            boolean validEventType = true;

            switch (eventType) {
                case 1:
                    System.out.println("通常イベントです。");
                    break;
                case 2:
                    System.out.println("ライブイベントです。");
                    break;
                case 3:
                    System.out.println("特別イベントです。");
                    break;
                default:
                    System.out.println("イベントタイプが正しくありません。");
                    validEventType = false;
                    break;
            }

            int seatFee = 0;
            boolean validSeatType = true;

            switch (seatType) {
                case 1:
                    System.out.println("自由席です。");
                    break;
                case 2:
                    System.out.println("指定席です。");
                    seatFee = 500;
                    break;
                case 3:
                    System.out.println("VIP席です。");
                    seatFee = 1500;
                    break;
                default:
                    System.out.println("座席タイプが正しくありません。");
                    validSeatType = false;
                    break;
            }

            if (validEventType && validSeatType) {
                int basicFee = 0;

                if (isMember) {
                    basicFee = 2500;
                } else if (hasStudentCard) {
                    basicFee = 2800;
                } else if (hasCoupon) {
                    basicFee = 3000;
                } else {
                    basicFee = 3500;
                }

                int totalFee = basicFee + seatFee;

                if (money >= totalFee) {
                    System.out.println("料金は足りています。\nおつりは" + (money - totalFee) + "円です。");
                } else {
                    System.out.println("料金が足りません。\n不足金額は" + (totalFee - money) + "円です。");
                }
            }
        }
    }
}