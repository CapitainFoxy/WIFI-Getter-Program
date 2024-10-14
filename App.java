import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiJelerossegiMonitor {

    public static void main(String[] args) {
        try {
            Process folyamat = Runtime.getRuntime().exec("netsh wlan show interfaces");
            BufferedReader olvaso = new BufferedReader(new InputStreamReader(folyamat.getInputStream()));
            String sor;
            while ((sor = olvaso.readLine()) != null) {
                if (sor.trim().startsWith("Signal")) {
                    String jelerosseg = sor.split(":")[1].trim();
                    System.out.println("Wi-Fi jelerossege: " + jelerosseg);
                }
            }
            olvaso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

