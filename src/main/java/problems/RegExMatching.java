package problems;

import Util.Result;

public class RegExMatching
{
	public static Result[][] mat;

	public static boolean isMatch(String s, String p)
	{
		if (p.isEmpty())
		{
			return s.isEmpty();
		}
		boolean firstCheck = (!s.isEmpty() && (s.charAt(0) == p.charAt(0)
				|| p.charAt(0) == '.')); /* checking s length as p is already checked*/
		if (p.length() >= 2 && p.charAt(1) == '*')
		{
			return isMatch(s, p.substring(2)) || (firstCheck && isMatch(s.substring(1), p));
		}
		else
		{
			return (firstCheck && isMatch(s.substring(1), p.substring(1)));
		}

	}

	public static boolean isMatchDP(String s, String p)
	{
		if (p.isEmpty())
		{
			return s.isEmpty();
		}

		mat = new Result[s.length() + 1][p.length() + 1];

		return dp(0, 0, s, p);

	}

	public static boolean dp(int row, int col, String s, String p)
	{

		System.out.println("call for row = " + row + " col = " + col);

		if (mat[row][col] != null)
		{
			return mat[row][col] == Result.TRUE;
		}

		boolean ans;

		if (col == p.length())
		{
			ans = row == s.length();
		}
		else
		{
			boolean first_match = row < s.length() && (p.charAt(col) == s.charAt(row) || p.charAt(col) == '.');
			if (col + 1 < p.length() && p.charAt(col + 1) == '*')
				ans = (dp(row, col + 2, s, p) || first_match && dp(row + 1, col, s, p));
			else
				ans = first_match && dp(row + 1, col + 1, s, p);

		}
		mat[row][col] = ans ? Result.TRUE : Result.FALSE;
		System.out.println("Transform for row = " + row + " col = " + col);
		printmatrix();
		return ans;

	}


	public static boolean newDPMatch(String s,String p){
		int n = s.length();
		int m = p.length();
		if(m==0){
			return n==0;
		}
		boolean[][] mat = new boolean[n+1][m+1];

		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				mat[i][j] = false;
			}
		}

		mat[0][0] = true;

		for(int j=1;j<=m;j++){
			if(p.charAt(j-1)=='*')
				mat[0][j]=mat[0][j-1];
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(p.charAt(j-1)==s.charAt(i-1)|| p.charAt(j-1)=='.'){
					mat[i][j] = mat[i-1][j-1];
				}
				else if(p.charAt(j-1)=='*'){
					mat[i][j] = mat[i-1][j]||mat[i][j-1];
				}
				else
					mat[i][j] = false;

			}
		}
		return mat[n][m];
	}

	static void printmatrix()
	{
		System.out.println("row=" + mat.length);
		System.out.println("col=" + mat[0].length);
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[0].length; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args)
	{
		String s = "aaa";
		String p = "a*";// consecutive * will fail the logic
		System.out.println(isMatch(s, p));
		System.out.println(isMatchDP(s, p));
		System.out.println(newDPMatch(s,p));
//		p = "a*";
//		System.out.println(isMatchDP(s, p));

	}
}
