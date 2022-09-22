import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class ConverterHandler extends JPanel{
    private Document doc;
    private JLabel rate;
    private Font rateFont;
    private Font errorFont;
    private String result;

    String searchError = "<html>None found check your spelling or the currency<br/>you search for may not exists</html>";
    String resultFormat = "%s %s to %s is %s";
    ConverterHandler(){                     
        rate = new JLabel("The results will show here");
        rateFont = new Font("SansSerif", Font.BOLD, 15);
        rate.setFont(rateFont);
        this.add(rate);
        this.setBounds(160, 150, 440, 200);
    }

    private String getReq(String firstCurrency, String secondCurrency, String amount) throws IOException{
        //searches through google so we don't have to hard code every possible currencies
        String url = "https://www.google.com/search?q=" + amount + firstCurrency + "+to+" + secondCurrency +"&rlz=1C1CHBF_enPH1018PH1018&oq=usd+to+php&aqs=chrome.0.69i59j0i512l9.3017j1j4&sourceid=chrome&ie=UTF-8#bsht=CgRmYnNtEgYIBBABGAE";
        doc = Jsoup.connect(url).get();    
        return doc.select("span[class=DFlfde SwHCTb]").text();
    }

    private void showError(String txt){
        rateFont = new Font("Futura", Font.BOLD, 10);
        rate.setFont(rateFont);
        rate.setText(txt);
    }

    public void showResult(String firstCurrency, String secondCurrency, String amount){
        try{
            result = getReq(firstCurrency, secondCurrency, amount);
            if(result != null && result.trim().isEmpty()){
                showError(searchError);
            } else {
                rateFont = new Font("SansSerif", Font.BOLD, 15);
                rate.setFont(rateFont);
                rate.setText(String.format(resultFormat, amount, firstCurrency, secondCurrency, result));
            }
        } catch (IOException e){
            e.printStackTrace();
            showError("Error Try again!");
        }
        
    }
}
