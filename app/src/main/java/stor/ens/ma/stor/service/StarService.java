package stor.ens.ma.stor.service;

import java.util.ArrayList;
import java.util.List;

import stor.ens.ma.stor.beans.Star;
import stor.ens.ma.stor.dao.IDao;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;

    private StarService() {
        stars = new ArrayList<>();
        seed();
    }

    public static StarService getInstance() {
        if (instance == null) instance = new StarService();
        return instance;
    }

    private void seed() {

        stars.add(new Star("Fulla", "https://tse1.mm.bing.net/th/id/OIP.ciu4yUX5tgMWaL5_wHWUAQHaE9?pid=Api&P=0&h=180", 4.2f));
        stars.add(new Star("Gambole", "https://tse4.mm.bing.net/th/id/OIP.KSSBx-Zdb63n76EmvBc0EgHaHa?pid=Api&P=0&h=180", 4.7f));
        stars.add(new Star("Kaptain Majid", "https://le12.ma/fr/wp-content/uploads/2024/01/capitain.jpg", 4.8f));
        stars.add(new Star("Romio", "https://i.ytimg.com/vi/fJQyDCYzSjY/hqdefault.jpg", 4.8f));
        stars.add(new Star("Cindrella", "https://i.pinimg.com/originals/92/5e/53/925e532add9ea9a207f899e1bfa50875.jpg", 4.8f));
        stars.add(new Star("Rapunzel", "https://i.pinimg.com/originals/c7/23/af/c723afab52d555f23888f01b46ffec98.jpg", 4.8f));
        stars.add(new Star("Blossom", "https://wallpapercave.com/wp/wp7742822.jpg", 4.8f));
        stars.add(new Star("Sally", "https://i.ytimg.com/vi/NGTFMnN8vOU/maxresdefault.jpg", 4.8f));

        stars.add(new Star("Scooby Doo", "https://tse2.mm.bing.net/th/id/OIP.um-HUH46YbEtXVqypI79xAHaEo?pid=Api&P=0&h=180", 4.8f));
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setRating(o.getRating());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
        for (Star s : stars) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }
}
