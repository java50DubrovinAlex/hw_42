

public class PrintPortions extends Thread {
	int index = 1;
	int totalPrint = 0;
	int threadNumber;
	int portion;
	PrintPortions next;
	int numbersOfPrint;
	
	public void setTotalPrint(int totalPrint) {
		this.totalPrint = totalPrint;
	}
	
	public void setNext(PrintPortions next) {
		this.next = next;
	}

	public PrintPortions(int threadNumber, int portion, int numbersOfPrint) {
		this.threadNumber = threadNumber;
		this.portion = portion;
		this.numbersOfPrint = numbersOfPrint;
	}
	
//	public void finish() {
//		running = false;
//	}
	@Override
	public void run() {
		
		while(totalPrint != numbersOfPrint) {
//			if(totalPrint == numbersOfPrint) {
//				next.finish();
//			}
			try {
				sleep(1000);
				
			} catch (InterruptedException e) {
				while(index <= portion && totalPrint != numbersOfPrint) {
					
					System.out.print(threadNumber + " ");
					totalPrint += 1;
					index++;
				}
				index = 1;
				System.out.println();
				System.out.println("current print number: " + totalPrint + " numbers of print: " + numbersOfPrint);
				next.setTotalPrint(totalPrint);
				next.interrupt();
				
			}
		}
	}
	
}
