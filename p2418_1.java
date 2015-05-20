import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2418_1 {
	
	//树节点
	public static class TreeNode{
		//树种的名字
		private String species;
		private TreeNode left;
		private TreeNode right;
		//该树种出现的次数
		private int count;
		
	}
	
	public static class Tree{
		//该区域树的总数
		private int total;
		private TreeNode root=new TreeNode();

		public void insert(String newSpecies,TreeNode root){
			//树为空
			if(root.count==0){
				
				root.species=newSpecies;
				root.count++;
				total++;
				return;
				
			}
			else{
				//比该结点小
				if(root.species.compareTo(newSpecies)>0){
					
					if(root.left==null){
						
						root.left=new TreeNode();
						
					}
					insert(newSpecies,root.left);
					
				}else{
					
					if(root.species.compareTo(newSpecies)<0){
						
						if(root.right==null){
							
							root.right=new TreeNode();
							
						}
						insert(newSpecies,root.right);	
						
					}else{
						
						root.count++;
						total++;
						
					}
					
				}
				
			}
			
		}
		
		//树的遍历输出(中序)
		public void travelTree(TreeNode root){
			
			if(root==null){
				
				return;
				
			}
			travelTree(root.left);
			System.out.print(root.species+" ");
			double p=(double)root.count*100/total;
			//控制输出精度
			System.out.printf("%.4f", p);
			System.out.println();
			travelTree(root.right);
			
		}
		
	}
	
	public static void main(String[] args){
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Tree t=new Tree();
		String s;
		
		try {
			while((s=reader.readLine())!=null){
				
                 //本地测试用
//				 if(s.compareTo("0")==0){
//								
//					 break;
//								
//				 }
				// System.out.println(s);

				t.insert(s,t.root);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("total: "+t.totalCount);
		t.travelTree(t.root);
		
	}

}
