class Arc {
    private String dest;
    private double cout;

    public Arc(String d, double c) {
        if (cout <= 0) {
            throw new IllegalArgumentException("Le coût de l'arc doit être strictement positif.");
        }
        this.dest = d;
        this.cout = c;
    }
}