import java.lang.Exception;
import java.time.LocalTime;
public final class Task1 {
    public static class Time{
        short hour;
        short minute;
        short second;
        Time(int hour, int minute, int second) throws Exception {
            this.hour = (short) hour;
            this.minute = (short) minute;
            this.second = (short) second;
            if(this.hour >= 24 || this.minute > 60 || this.second > 60){
                throw new Exception("Invalid input");
            }
        }
        Time(String time) throws Exception {
            String[] values = time.split(":");
            this.hour = Short.parseShort(values[0]);
            this.minute = Short.parseShort(values[1]);
            this.second = Short.parseShort(values[2]);
            if(this.hour >= 24 || this.minute >= 60 || this.second >= 60){
                throw new Exception("Invalid input");
            }
        }
        Time(int second) throws Exception {
            if (second <= 0){
                this.hour = 0;
                this.minute = 0;
                this.second = 0;
                return;
            }
            this.second = (short) (second % 60);
            this.minute = (short) ((second/60)%60);
            this.hour = (short) (second/3600);
            if(this.hour >= 24){
                throw new Exception("Invalid input");
            }
        }
        Time(){
            LocalTime time = LocalTime.now();
            this.hour = (short) time.getHour();
            this.minute = (short) time.getMinute();
            this.second = (short) time.getSecond();
        }
        public void print(){
            String buff1 = (this.hour < 10) ? "0" : "";
            String buff2 = (this.minute < 10) ? "0" : "";
            String buff3 = (this.second < 10) ? "0" : "";
            System.out.print(buff1 + this.hour  + ':' + buff2 + this.minute + ':' + buff3 + this.second);
        }
        public int toSeconds(){
            return (this.hour*60 + this.minute)*60 + this.second;
        }
        public int toMinutes(){
            return this.hour * 60 + this.minute;
        }
        public static boolean compare(Time time1, Time time2){
            if(time1.hour > time2.hour) return true;
            else if (time1.minute > time2.minute) return true;
            else return time1.second > time2.second;
        }
        public static int subtraction(Time time1, Time time2){
            return time1.toSeconds() - time2.toSeconds();
        }
        public static Time subtraction(Time time, int second) throws Exception {
            return new Time(time.toSeconds() - second);
        }
        public static Time sum(Time time1, Time time2) throws Exception {
            return new Time(time1.toSeconds() + time2.toSeconds());
        }
        public static Time sum(Time time, int second) throws Exception {
            return new Time(time.toSeconds() + second);
        }
    }
    public static void task1() throws Exception {
        Time time1 = new Time("1:05:20");
        Time time2 = new Time();
        Time time3 = new Time(3720);
        System.out.print(Time.compare(time1, time3));
        System.out.print('\n');
        System.out.print(Time.subtraction(time1, time3));
        System.out.print('\n');
        Time.sum(time1, time3).print();
        System.out.print('\n');
        Time.subtraction(time1,10).print();
        System.out.print('\n');
        Time.sum(time3,10).print();
        System.out.print('\n');
        System.out.print(time2.toSeconds());
        System.out.print('\n');
        System.out.print(time2.toMinutes());
    }
}