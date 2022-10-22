/*
John wants to save money for his first car. He puts money in his piggy bank every day.
Every day, he puts in $1 more than the previous day.
Every Monday he starts with a new value ⁠— $1 more than the previous Monday.
Write a function that returns the number of days he needs to buy his first car cost.
John had some savings (include it before counting).
On the first Monday, he puts the start amount into his piggy bank.
 */

public class MoneyChallenge {
    public int NumberOfDays(int cost, int start, int startAmount){
        int days=0;
        int weekMoney=startAmount;
        while(start<cost){
            if (days!=0 && days%7 == 0) {
                startAmount++;
                weekMoney=startAmount;
            }
            if(cost - (start + (weekMoney*7+ (6 * (6 + 1) / 2))) <= 0){
                int i=0;
                boolean end=false;
                while(!end){
                    i++;
                    if (i-1==0){
                        if(cost - start+ weekMoney <=0) {
                            days+=i;
                            end=true;
                        }
                    }
                    else{
                        if((cost - (start + (weekMoney*i + ((i-1) * (i) / 2))))<=0){
                            end=true;
                            days+=i;
                        }
                    }
                }
                start += i==1 ? weekMoney :  (weekMoney*i + ((i-1) * (i) / 2));
            }
            else {
                days += 7;
                start += (weekMoney*7+ (6 * (6 + 1) / 2));
                weekMoney++;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        MoneyChallenge m= new MoneyChallenge();
        System.out.println(m.NumberOfDays(2050, 1200, 10)); //53
        System.out.println(m.NumberOfDays(10000, 2500, 50)); // 123
        System.out.println(m.NumberOfDays(500, 300, 50)); //4
    }
}
