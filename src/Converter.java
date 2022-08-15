public class Converter {
    double distance(int step) {
        double dist = (step * 75) / 100000;
        return dist;
    }

    double kalor(int step) {

        double kal = (step * 50) / 1000;
        return kal;
    }

}
