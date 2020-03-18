package designpattern.gof_builder.sample01;

public class DropShip {

    private int dropshipCapacity = 8;

    private int SeigeTankSize = 0;
    private int MarineSize = 0;
    private int MedicSize = 0;
    private int FireBatSize = 0;
    private int VultureSize = 0;
    private int GhostSize = 0;
    private int GoliathSize = 0;

    private boolean SeigeTankOnBoard = false;
    private boolean MarineOnBoard = false;
    private boolean MedicOnBoard = false;
    private boolean FireBatOnBoard = false;
    private boolean VultureOnBoard = false;
    private boolean GhostOnBoard = false;
    private boolean GoliathOnBoard = false;

    public static class Builder {

        // 필수 값
        private final int dropshipCapacity;

        private int SeigeTankSize = 4;
        private boolean SeigeTankOnBoard = false;
        private int MarineSize = 1;
        private boolean MarineOnBoard = false;
        private int MedicSize = 1;
        private boolean MedicOnBoard = false;
        private int FireBatSize = 1;
        private boolean FireBatOnBoard = false;
        private int VultureSize = 2;
        private boolean VultureOnBoard = false;
        private int GhostSize = 1;
        private boolean GhostOnBoard = false;
        private int GoliathSize = 2;
        private boolean GoliathOnBoard = false;

        public Builder(int dropshipCapacity) {
            this.dropshipCapacity = dropshipCapacity;
        }

        public Builder SeigeTank(int SeigeTankCount) {
            SeigeTankSize = SeigeTankSize * SeigeTankCount;
            SeigeTankOnBoard = true;
            return this;
        }

        public Builder Marine(int MarineCount) {
            MarineSize = MarineSize * MarineCount;
            MarineOnBoard = true;
            return this;
        }

        public Builder Medic(int MedicCount) {
            MedicSize = MedicSize * MedicCount;
            MedicOnBoard = true;
            return this;
        }

        public Builder FireBat(int FireBatCount) {
            FireBatSize = FireBatSize * FireBatCount;
            FireBatOnBoard = true;
            return this;
        }

        public Builder Vulture(int VultureCount) {
            VultureSize = VultureSize * VultureCount;
            VultureOnBoard = true;
            return this;
        }

        public Builder Ghost(int GhostCount) {
            GhostSize = GhostSize * GhostCount;
            GhostOnBoard = true;
            return this;
        }

        public Builder Goliath(int GoliathCount) {
            GoliathSize = GoliathSize * GoliathCount;
            GoliathOnBoard = true;
            return this;
        }

        public DropShip onBoard() {
            return new DropShip(this);
        }
    }

    private DropShip(Builder builder) {
        dropshipCapacity = builder.dropshipCapacity;
        SeigeTankSize = builder.SeigeTankSize;
        MarineSize = builder.MarineSize;
        MedicSize = builder.MedicSize;
        FireBatSize = builder.FireBatSize;
        VultureSize = builder.VultureSize;
        GhostSize = builder.GhostSize;
        GoliathSize = builder.GoliathSize;

        SeigeTankOnBoard = builder.SeigeTankOnBoard;
        MarineOnBoard = builder.MarineOnBoard;
        MedicOnBoard = builder.MedicOnBoard;
        FireBatOnBoard = builder.FireBatOnBoard;
        VultureOnBoard = builder.VultureOnBoard;
        GhostOnBoard = builder.GhostOnBoard;
        GoliathOnBoard = builder.GoliathOnBoard;
    }

    public String checkOnBoardMember() {
        String onBoardList = "";

        if (SeigeTankOnBoard) onBoardList += " 시즈탱크 탑승 : " + SeigeTankSize + "\r\n";
        if (MarineOnBoard) onBoardList += " 마린 탑승 : " + MarineSize + "\r\n";
        if (MedicOnBoard) onBoardList += " 메딕 탑승 : " + MedicSize + "\r\n";
        if (FireBatOnBoard) onBoardList += " 파이어벳 탑승 : " + FireBatSize + "\r\n";
        if (VultureOnBoard) onBoardList += " 벌처 탑승 : " + VultureSize + "\r\n";
        if (GhostOnBoard) onBoardList += " 고스트 탑승 : " + GhostSize + "\r\n";
        if (GoliathOnBoard) onBoardList += " 골리앗 탑승 : " + GoliathSize + "\r\n";

        return onBoardList;
    }
}
