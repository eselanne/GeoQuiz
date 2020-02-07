package app;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ResourceLoader<N extends Parent, C> {
    public final N root;
    protected final C controller;

    public ResourceLoader(String contentPath) {
        N root_ = null;
        C controller_ = null;
        try {
            // determines where to look for the resources (the root path)
           // Class resourceRootClass = getClass();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeoQuiz/src/main/resources/MainMenu.fxml"));
            root_ = loader.load();
            controller_ = loader.getController();
            System.out.println("DEBUG: " + contentPath + " loaded.");
        } catch (Exception e) {
        	System.out.println(e);
            System.exit(1);
        }
        root = root_;
        controller = controller_;
    }

    // finds images both outside and inside jars
    public static String image(String fileName) {
        return ResourceLoader.class.getResource(fileName).toExternalForm();
    }
}
