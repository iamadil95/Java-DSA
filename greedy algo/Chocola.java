import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m -1
        Integer costHor[] = { 4, 1, 2, }; // n-1
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
         
        int hCut = 0, vCut = 0;
        int hPc = 1, vPc = 1;
        int cost = 0;

        while (hCut < costHor.length && vCut < costVer.length) {
            //vertical cost less than horizontal cost
            if (costVer[vCut] <= costHor[hCut]) { // horizontal cut
                cost += (costHor[hCut] * vPc);
                hPc++;
                hCut++;
            } else { // vertical cut
                cost += (costVer[vCut] * hPc);
                vPc++;
                vCut++;
            }
        }
        while (hCut < costHor.length) {

            cost += (costHor[hCut] * vPc);
            hPc++;
            hCut++;
        }
        while (vCut < costVer.length) {
            cost += (costVer[vCut] * hPc);
            vPc++;
            vCut++;
        }
        System.out.println("minimum cost of choco cuts =" + cost);
    }
}
