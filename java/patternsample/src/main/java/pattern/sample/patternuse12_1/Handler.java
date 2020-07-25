package pattern.sample.patternuse12_1;

public abstract class Handler {
    protected CatalogApp catalogApp;

    public Handler(CatalogApp catalogApp){
        this.catalogApp = catalogApp;
    }
}
