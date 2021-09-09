package AmazonBadNumber;

//private static int getLongestSegment(int[] badNumbers, int lower, int upper) {
//    int longestSegment = 0;
//    int currentSegment = 0;
//    int lastGoodNumber = lower;
//
//    // Sort bad numbers
//    Arrays.sort(badNumbers);
//
//    // Traverse over bad numbers, exploring left segment till all numbers are covered or upper is exceeded
//    for (int i = 0; i < badNumbers.length && badNumbers[i] <= upper; i++) {
//        currentSegment = badNumbers[i] - lastGoodNumber;
//        if (currentSegment > longestSegment) {
//            longestSegment = currentSegment;
//        }
//
//        lastGoodNumber = badNumbers[i] + 1;
//    }
//
//    // Handle left segment of upper
//    currentSegment = upper - lastGoodNumber + 1;
//    if (currentSegment > longestSegment) {
//        longestSegment = currentSegment;
//    }
//
//    return longestSegment;
//}


public int getLongestSegment(int[] badNumbers, int lower, int upper) {
	Collections.sort(badNumbers); 
	int maxLength = Integer.MIN_VALUE;
	if (badNumbers[0] > upper || badNumbers[-1] < lower) {
		return 0;
	}
	int i=0;
	while(badNumbers[i] < lower) {
		i++;
	}
	int start = i;
	for (int i; i < badNumbers.length(); i++) {
		if ( badNumbers[i] > upper ) {
			maxLength = Math.max(maxLength, upper - badNumebrs[i-1]);
			break;
		}
		if ( i == start ) {
			maxLength = Math.max(maxLength, badNumebrs[i] - lower);
		} else {
			maxLength = Math.max(maxLength, badNumbers[i] - badNumbers[i-1] - 1);
		}
	}
	return maxLength;

}