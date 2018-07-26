// L7Q1.scala

/*
	See lab handout for information.
*/

// Binary Tree
// T ::= Nil | T <- A -> T
// A is a generic language
sealed abstract class BT[+A] // T
case object Empty extends BT // Nil
case class BTNode[A](l:BT[A],d:A,r:BT[A]) extends BT[A] // Tl <- Ad -> Tr

def BTfoldLeft[A,B](t:BT[A])(z:B)(cb:(B,A)=>B):B = t match {
	case Empty => z
	case BTNode(l,d,r) => BTfoldLeft(r)(cb(BTfoldLeft(l)(z)(cb),d))(cb)
}
def BTfoldRight[A,B](t:BT[A])(z:B)(cb:(A,B)=>B):B = t match {
	case Empty => z
	case BTNode(l,d,r) => BTfoldRight(l)(cb(d,BTfoldRight(r)(z)(cb)))(cb)
}
def BTmap[A,B](t:BT[A])(cb:A=>B):BT[B] = t match {
	case Empty => Empty
	case BTNode(l,d,r) => BTNode(BTmap(l)(cb),cb(d),BTmap(r)(cb))
}


// Binned Tree
// B ::= Nil | B <- L -> B
// L ::= Nil | A :: L
type BinT[A] = BT[List[A]]

def testBTLLfoldLeft() = {
	// oTODO
}
def BTLLfoldLeft[A,B](t:BinT[A])(z:B)(cb:(B,A)=>B):B = {
	// TODO
	z
}

def testBTLLmap() = {
	// oTODO
}
def BTLLmap[A,B](t:BinT[A])(cb:A=>B):BinT[B] = {
	// TODO
	Empty
}


def testSumBinnedTree() {
	// oTODO
}
// implement sumBinnedTree according to the spec provided
// TODO

def nonEmptyAndSame[A](l:List[A]):(Option[A],Boolean) = {
	// option TODO
	// a recommended helper function for isBinnedSearchTree
	(None,false)
}

def testIsBinnedSearchTree() = {
	// oTODO
}
def isBinnedSearchTree(t:BinT[Int]):Boolean = {
	// TODO
	false
}


def test() {
	testIsBinnedSearchTree();
	testBTLLmap();
	testSumBinnedTree();
	testBTLLfoldLeft();
}

test












