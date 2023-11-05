

public class PrintPortionsControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		int threadsNumber = 4;
		int portion = 10;
		int numbersOfPrint = 100;
		PrintPortions [] threadArray  = getThreadArray(threadsNumber, portion, numbersOfPrint);
		setNext(threadArray);
		startAllthreads(threadArray);
		threadArray[0].interrupt();
	}

	private static void startAllthreads(PrintPortions[] threadArray) {
		for(int i = 0; i < threadArray.length;i++) {
			threadArray[i].start();
		}
	}

	private static void setNext(PrintPortions [] threadArray) {
		
		for(int i = 0; i < threadArray.length;i++) {
			if(i == threadArray.length - 1) {
				threadArray[threadArray.length - 1].setNext(threadArray[0]);
			}else {
				threadArray[i].setNext(threadArray[i + 1]);
			}
		}
	}


	private static PrintPortions[] getThreadArray(int length, int portion, int numbersOfPrint) {
		PrintPortions [] threadArray = new PrintPortions[length];
		for(int i = 0; i < length; i++) {
			threadArray[i] = new PrintPortions(i + 1, portion, numbersOfPrint);
		}
		return threadArray;
	}
}
