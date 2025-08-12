package main;

public class Bits {

	public void printBits(int n) {
		if (n < 2) {
			System.out.print(n);
			return;
		}
		int bit = n % 2;
		printBits(n / 2);
		System.out.print(bit);
	}

	public void printBitsReversed(int n) {
		while (n != 0) {
			System.out.print(n % 2);
			n = n / 2;
		}
	}

	public void printBitsReversed2(int n) {
		while (n != 0) {
			System.out.print(n % 2);
			n = n / 2;
		}
	}

	public int getBit(int n, int pos) {
		int mask = (1 << pos);
		return (n & mask) == 0 ? 0 : 1;
	}

	public void setBit(int n, int pos) {
		int mask = (1 << pos);
		n = n | mask;
	}

	public void clearBit(int n, int pos) {
		int mask = ~(1 << pos);
		n = n & mask;
	}

	public void updateBit(int n, int pos, int val) {
		int mask = ~(1 << pos);
		n = n & mask;
		n = n | (val << pos);
	}

	public boolean powerOf2(int n) {
		return getBit(n, 0) == 0;
	}
}