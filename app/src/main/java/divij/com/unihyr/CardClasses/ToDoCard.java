package divij.com.unihyr.CardClasses;

public class ToDoCard {
    private String name,position,source,since;

    public ToDoCard(String name, String position, String source, String since) {
        this.name = name;
        this.position = position;
        this.source = source;
        this.since = since;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }
}
