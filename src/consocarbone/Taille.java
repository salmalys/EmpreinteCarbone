package consocarbone;

public enum Taille {
    P(4.2),G(19);
	
	double consVoit;
	
	Taille(double consVoit){
		this.consVoit = consVoit;
	}
	
	public double getConsVoit() {
		return consVoit;
	}
}
