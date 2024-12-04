package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2){
        if(o1.getCost() > o2.getCost()){
            return -1; //Chi phi giam dan
        }
        else if (o1.getCost() < o2.getCost()){
            return 1;
        }
        else{ //Neu chi phi bang nhau thi so sanh theo title
            if(o1.getTitle() != null && o2.getTitle() != null)
                return -o1.getTitle().compareTo(o2.getTitle());
            if(o1.getTitle() == null && o2.getTitle() != null)
                return 1;
            if(o1.getTitle() != null && o2.getTitle() == null)
                return -1;
            return 0;
        }
    }

    
}
