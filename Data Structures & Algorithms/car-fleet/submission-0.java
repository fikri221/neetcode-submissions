class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // gabung posisi dan kecepatan kedalam array 2D
        int[][] cars = new int [n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // urutkan mulai dari posisi yang terdekat dengan target
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] car : cars) {
            // hitung waktu sampai ke target
            double time = (double) (target - car[0]) / car[1];
            stack.push(time);

            // Jika ada minimal 2 mobil di stack, dan mobil yang baru masuk (top)
            // waktunya <= mobil di depannya, maka mobil ini menyusul & bergabung
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop(); // Hapus mobil belakang karena sudah bergabung dengan fleet depan
            }
        }

        return stack.size();
    }
}
