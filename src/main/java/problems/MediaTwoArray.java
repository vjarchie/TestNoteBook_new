package problems;

public class MediaTwoArray
{
	 static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		double m1=0,m2=0;
		int i=0,j=0;

		if((l1+l2)%2 == 1){
			for(int k=0; k<=(l1+l2)/2;k++){
				if(i!=l1 && j!=l2){
					m1 = (nums1[i]>nums2[j] ? nums2[j++]:nums1[i++]);
				}
				else if(i<l1){
					m1= nums1[i++];
				}
				else{
					m1 = nums2[j++];
				}

			}
			return m1;
		}
		else{

			for(int k=0; k<=(l1+l2)/2;k++){
				m2=m1;
				if(i!=l1 && j!=l2){
					m1 = (nums1[i]>nums2[j] ? nums2[j++]:nums1[i++]);
				}
				else if(i<l1){
					m1= nums1[i++];
				}
				else{
					m1 = nums2[j++];
				}

			}
			double t = (m1+m2)/2;
			return t;

		}

	}

	public static void main(String args[]){
		int[] m1 = {1,2};
		int[] m2 = {3,4};
		double result = findMedianSortedArrays(m1,m2);
		System.out.println(result);
	}
}
