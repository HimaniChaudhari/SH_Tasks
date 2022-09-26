package star.demo.jdbc.model;

public class Books { // model


    private  int bid;
    private String bname;
    private double bprice;
    private  String bdate;

    public Books() {


    }

    public Books(int bid, String bname, double bprice, String bdate) {
        super();
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bdate = bdate;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	@Override
    public String toString() {
        return "Employee [eid=" + bid + ", ename=" + bname + ", salary=" + bprice + ", bdate=" + bdate +"]";
    }





}

