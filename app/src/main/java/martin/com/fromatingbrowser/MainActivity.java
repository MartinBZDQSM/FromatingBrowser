package martin.com.fromatingbrowser;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Document document = null;
            try {
                document = Jsoup.connect("http://www.biquge.com.tw/0_213/6996985.html").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null != document) {
                List<Element> elements = document.getAllElements();
//                loggingElementMsg(elements);
//                Logger.(elements);
//                List<Node> nodes = document.childNodes();
//                loggingMsg(nodes);
            }
        }
    };

    private void loggingElementMsg(List<Element> elements) {
        for (Element element : elements) {
//            if (!element.children().isEmpty()) {
//                loggingElementMsg(element.children());
//            } else {

//            }

        }
    }

    private void loggingNodeMsg(List<Node> nodes) {
        for (Node node : nodes) {
            if (!node.childNodes().isEmpty()) {
                loggingNodeMsg(node.childNodes());
            } else {
                Logger.d(node);
            }

        }
    }
}
