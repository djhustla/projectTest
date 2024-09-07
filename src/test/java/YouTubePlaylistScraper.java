import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class YouTubePlaylistScraper {


    private static final String PLAYLIST_URL = "https://www.youtube.com/playlist?list=PL9tY0BWXOZFsNzEZ8FkLLkyBeQ6XjUyLM";

    public static void main(String[] args) {
        try {
            // Se connecter à la page YouTube de la playlist et récupérer le document HTML
            Document doc = Jsoup.connect(PLAYLIST_URL).get();

            //System.out.println(doc);

            // Sélectionner tous les éléments qui contiennent les vidéos de la playlist
            Elements videoElements = doc.select("a.yt-simple-endpoint.style-scope.ytd-playlist-video-renderer");

            // Parcourir chaque élément pour obtenir l'ID et le titre de la vidéo
            for (Element videoElement : videoElements) {
                // Récupérer l'ID de la vidéo
                String videoId = videoElement.attr("href").split("v=")[1].split("&")[0];
                // Récupérer le titre de la vidéo
                String title = videoElement.text();

                // Afficher le titre et l'ID de la vidéo
                System.out.println("Titre : " + title);
                System.out.println("Video ID : " + videoId);
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}