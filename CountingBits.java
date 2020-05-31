class CountingBits {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        if (num == 0) {
            return bits;
        }
        bits[1] = 1;
        int power = 2;
        for (int i = 2; i <= num; i++) {
            if (i == (int)Math.pow(2, power)) {
                power++;
            }
            bits[i] = 1 + bits[i - (int)Math.pow(2, power - 1)];
        }
        return bits;
    }
}
