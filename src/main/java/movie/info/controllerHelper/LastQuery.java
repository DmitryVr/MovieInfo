package movie.info.controllerHelper;

/**
 * как был получен список фильмов:
 * по чем был запрос и параметр
 */
public class LastQuery {
    private SavedQuery savedQuery;
    private String parameter;

    public LastQuery() {
    }

    public LastQuery(SavedQuery savedQuery, String parameter) {
        this.savedQuery = savedQuery;
        this.parameter = parameter;
    }

    public SavedQuery getSavedQuery() {
        return savedQuery;
    }

    public void setSavedQuery(SavedQuery savedQuery) {
        this.savedQuery = savedQuery;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
