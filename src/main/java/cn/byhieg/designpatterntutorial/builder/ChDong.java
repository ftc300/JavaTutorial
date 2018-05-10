package cn.byhieg.designpatterntutorial.builder;

public class ChDong {
    private int age ;
    private boolean gender;
    private String name;


    public static void main(String[] args) {
        ChDong cd = new ChDong.ChDongBuilder()
                .withAge(10)
                .withGender(true)
                .build();

    }
    public static final class ChDongBuilder {
        int age;
        boolean gender;
        String name;

        private ChDongBuilder() {
        }

        public static ChDongBuilder aChDong() {
            return new ChDongBuilder();
        }

        public ChDongBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public ChDongBuilder withGender(boolean gender) {
            this.gender = gender;
            return this;
        }

        public ChDongBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ChDong build() {
            ChDong chDong = new ChDong();
            chDong.gender = this.gender;
            chDong.age = this.age;
            chDong.name = this.name;
            return chDong;
        }
    }

}
