Binary Search Template:
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
---------------------------------------------------

Classical Binary Search
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length-1;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid;
            else 
                end = mid;
        }
        
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        return -1;
    }
}
---------------------------------------------------

First Position of Target
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                end = mid;
            else if(nums[mid] < target)
                start = mid;
            else 
                end = mid;
        }
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        return -1;
    }
}
---------------------------------------------------

Last Position of Target
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or start = mid - 1
            }
        }
        
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
---------------------------------------------------

First Bad Version
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(SVNRepo.isBadVersion(mid))
                end = mid;
            else
                start = mid;
        }
        if(SVNRepo.isBadVersion(start))
            return start;
        return end;
    }
}
---------------------------------------------------

Search in a Big Sorted Array
/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;
        while(reader.get(index-1) < target) index = index*2;
        int start = 0, end = index-1;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(reader.get(mid) == target) 
                end = mid;
            else if(reader.get(mid) < target) 
                start = mid;
            else
                end = mid;
        }
        if(reader.get(start) == target)
            return start;
        if(reader.get(end) == target)
            return end;
        return -1;
    }
}
---------------------------------------------------

Find Minimum in Rotated Sorted Array
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int target = nums[nums.length-1];
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] <= target) 
                end = mid;
            else
                start = mid;
        }
        if(nums[start] <= target)
            return nums[start];
        else
            return nums[end];
    }
}
---------------------------------------------------

Search a 2D Matrix
public class Solution {
    /**
      * Search twice:
      * 1. Find row;
      * 2. Find number;
      */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target)
                return true;
            else if(matrix[mid][0] < target)
                start = mid;
            else
                end = mid;
        }
        
        // end mast be checked first
        if(matrix[end][0] <= target)
            row = end;
        else if(matrix[start][0] <= target)
            row = start;
        else
            return false;
            
        start = 0; 
        end = col-1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                start = mid;
            else
                end = mid;
        }
        
        if(matrix[row][start] == target)
            return true;
        else if(matrix[row][end] == target)
            return true;
        return false;
    }
}
---------------------------------------------------

Search a 2D Matrix II
public class Solution {
    /**
     * From bottom left to top right
     */
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return 0;
        if(matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int x = row-1, y = 0, count = 0;
        while(x >= 0 && y < col) {
            if(matrix[x][y] < target) {
                y++;
            }
            else if(matrix[x][y] > target) {
                x--;
            }
            else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}
---------------------------------------------------

Search for a Range
public class Solution {
    /** 
     * 1. Find left bound;
     * 2. Find right bound;
     */
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0) return new int[]{-1, -1};
        int first = -1, second = -1;

        // Binary search find left bound
        int start = 0, end = A.length-1;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        // check start first
        if(A[start] == target)
            first = start;
        else if(A[end] == target)
            first = end;
            
        // Binary search find right bound
        start = 0; 
        end = A.length-1;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        // check end first
        if(A[end] == target)
            second = end;
        else if(A[start] == target)
            second = start;
            
        return new int[]{first, second};
    }
}
---------------------------------------------------

Total Occurrence of Target
public class Solution {
    /**
     * 1. Find left; 
     * 2. Find right; 
     * 3. Difference;
     */
    public int totalOccurrence(int[] A, int target) {
        if(A == null || A.length == 0) return 0;
        int left = -1, right = -1;
        int start = 0, end = A.length-1;
        while(start + 1 < end) {
            int mid = (start + end) >> 1;
            if(A[mid] >= target) 
                end = mid;
            else
                start = mid;
        }
        if(A[start] == target)
            left = start;
        else if(A[end] == target)
            left = end;
        else
            return 0;
            
        start = 0;
        end = A.length-1;
        while(start + 1 < end) {
            int mid = (start + end) >> 1;
            if(A[mid] <= target) 
                start = mid;
            else
                end = mid;
        }
        if(A[end] == target)
            right = end;
        else if(A[start] == target) 
            right = start;
        else
            return 0;
            
        return (left != -1 && right != -1) ? right - left + 1 : 0;
    }
}
---------------------------------------------------

Maximum Number in Mountain Sequence
public class Solution {
    /**
     * 
     */
    public int mountainSequence(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length-1;
        while(start + 1 < end) {
            int m1 = start + (end-start)/2;
            int m2 = end - (end-m1)/2;
            if(nums[m1] < nums[m2])
                start = m1+1;
            else if(nums[m1] > nums[m2])
                end = m2-1;
            else {
                start = m1;
                end = m2;
            }
        }
        return (nums[start] > nums[end]) ? nums[start] : nums[end];
    }
}
---------------------------------------------------

Find Peak Element
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if(A == null || A.length == 0) return -1;
        
        int start = 1, end = A.length-2;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(A[mid] > A[mid-1])
                start = mid;
            else if(A[mid] < A[mid+1])
                end = mid;
            else 
                end = mid;
        }
        if(A[start] < A[end])
            return end;
        else
            return start;
    }
}
---------------------------------------------------

Search in Rotated Sorted Array
public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        int start = 0, end = A.length-1;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(A[mid] == target)
                return mid;
            if(A[start] < A[mid]) {
                if(A[start] <= target && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if(A[mid] <= target && target <= A[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if(A[start] == target)
            return start;
        else if(A[end] == target)
            return end;
        return -1;
    }
}
---------------------------------------------------

Sqrt(x)
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        long start = 1, end = x;
        while(start + 1 < end) {
            long mid = start + (end-start)/2;
            long sqr = mid * mid;
            if(sqr == x)
                start = mid;
            else if(sqr < x)
                start = mid;
            else
                end = mid;
        }
        if(end * end <= x)
            return (int)end;
        return (int)start;
    }
}
---------------------------------------------------

Wood Cut
public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int max = 0;
        for(int i = 0; i < L.length; i++) 
            max = Math.max(max, L[i]);
        int start = 1, end = max;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(count(L, mid) >= k)
                start = mid;
            else
                end = mid;
        }
        if(count(L, end) >= k)
            return end;
        else if(count(L, start) >= k)
            return start;
        return 0;
    }
    
    private int count(int[] L, int len) {
        int sum = 0;
        for(int i = 0; i < L.length; i++) {
            sum += L[i] / len;
        }
        return sum;
    }
}
---------------------------------------------------

