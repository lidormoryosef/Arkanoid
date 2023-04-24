package sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * sprites.SpriteCollection will hold a collection of sprites.
 */
public class SpriteCollection {
    private ArrayList<Sprite> listSprite;

    /**
     * list of sprites.
     */
    public SpriteCollection() {
        this.listSprite = new ArrayList<>();
    }

    /**
     * add a sprite to array list.
     * @param s , sprite.
     */
    public void addSprite(Sprite s) {
        this.listSprite.add(s);

    }

    /**
     * getter.
     * @return list of sprites.
     */
    public ArrayList<Sprite> getListSprite() {
        return listSprite;
    }

    /**
     * update the list sprite.
     * @param listSprite , array list.
     */
    public void setListSprite(ArrayList listSprite) {
        this.listSprite = listSprite;
    }
    /**
     *  call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        ArrayList<Sprite> listSpriteTemp = new ArrayList<Sprite>(this.listSprite);
        for (int i = 0; i < listSpriteTemp.size(); i++) {
            listSpriteTemp.get(i).timePassed();
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * call drawOn(d) on all sprites.
     * @param d , DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.listSprite.size(); i++) {
            this.listSprite.get(i).drawOn(d);
        }
    }
}
