class Arc {
    private String dest;
    private double cout;

    public Arc(String d, double c) {
        if(c <= 0){
            throw new IllegalArgumentException("Le cout doit être positif");
        }
        this.dest = d;
        this.cout = c;
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }


}