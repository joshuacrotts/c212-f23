class Url {

  private String _scheme;
  private String _domain;
  private String _path;
  private String _query;

  private boolean complete;

  public Url() {}

  public Url scheme(String _scheme) {
    this._scheme = _scheme;
    return this;
  }

  public Url domain(String _domain) {
    this._domain = _domain;
    return this;
  }

  public Url path(String _path) {
    this._path = _path;
    return this;
  }

  public Url query(String _query) {
    this._query = _query;
    return this;
  }

  public Url build() {
    if (this._scheme == null || this._domain == null) {
      throw new RuntimeException("build: cannot build url");
    } else {
      if (this._path == null) { this._path = ""; }
      if (this._query == null) { this._query = ""; }
      this.complete = true;
      return this;
    }
  }

  public static void main(String[] args) {
    Url url = new Url().scheme("https")
                       .domain("google.com")
                       .path("search")
                       .domain("bing.com")
                       .scheme("http")
                       .build();
  }
}
