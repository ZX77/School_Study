package T5;

public class Woodwinds extends Wind{

	public Woodwinds() {
		System.out.println("我是木制风笛");
	}
	public void callInstrument(Instrument ins1){
		System.out.println(ins1);
	}
	public void callInstrument2(Instrument2 ins1){
		System.out.println(ins1);
	}
	public void callInstrument3(Instrument3 ins1){
		System.out.println(ins1);
	}
	public void callInstrument4(Instrument4 ins1){
		System.out.println(ins1);
	}
//	@Override
//	public String toString() {
//		return "木制风笛很好听......";
//	}
	public static void main(String[] args) {
		Woodwinds wind = new Woodwinds();
		
		Woodwinds wind2 = new Woodwinds();

		wind.callInstrument(wind2);
		wind.callInstrument2(wind2);
		wind.callInstrument3(wind);
		wind.callInstrument4(wind);
		
	}
}
