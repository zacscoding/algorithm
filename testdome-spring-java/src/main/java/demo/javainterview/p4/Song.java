package demo.javainterview.p4;

/**
 * TODO : solve
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song next = nextSong;

        while (true) {
            if (next == null) {
                return false;
            }

            if (next == this) {
                return true;
            }

            next = next.nextSong;
        }
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}