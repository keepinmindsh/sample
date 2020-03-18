package sample.CommentSample;

public class CommentSample {

    public static Flag flag;

    public static void main(String[] args) {
        // 직원의 복지 혜택 자격 여부를 검사한다.
        if(  (worker.flags & Flag.HOURLY_FLAG == flag) && ( worker.ages > 65) ){
            System.out.println("문법을 통과했어~!");
        }


        if(worker.isEligiableForFullBenefits()){
            System.out.println("문법을 통과했어~!");
        }

    }

}

class worker {
    public static boolean flags = true;
    public static int ages = 70;
    public static Flag flag;

    public static boolean isEligiableForFullBenefits(){
        return (worker.flags & Flag.HOURLY_FLAG == flag) && ( worker.ages > 65);
    }

}

enum Flag {
    HOURLY_FLAG
}
