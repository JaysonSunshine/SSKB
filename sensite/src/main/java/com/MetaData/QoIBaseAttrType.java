////////////////////////////////////////////////////////////////////////
//
// QoIBaseAttrType.java
//
// This file was generated by XMLSpy 2014 Enterprise Edition.
//
// YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
// OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
//
// Refer to the XMLSpy Documentation for further details.
// http://www.altova.com/xmlspy
//
////////////////////////////////////////////////////////////////////////

package com.MetaData;

public class QoIBaseAttrType extends com.altova.xml.TypeBase
{
	public static com.altova.xml.meta.ComplexType getStaticInfo() { return new com.altova.xml.meta.ComplexType(com.MetaData.MetaData_TypeInfo.binder.getTypes()[com.MetaData.MetaData_TypeInfo._altova_ti_altova_QoIBaseAttrType]); }
	
	public QoIBaseAttrType(org.w3c.dom.Node init)
	{
		super(init);
		instantiateMembers();
	}

	private void instantiateMembers()
	{
		name = new MemberAttribute_name (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._name]);
		id = new MemberAttribute_id (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._id]);

		QoIIntegrityAttr= new MemberElement_QoIIntegrityAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._QoIIntegrityAttr]);
		QoIAccuracyAttr= new MemberElement_QoIAccuracyAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._QoIAccuracyAttr]);
		QoITimelinessAttr= new MemberElement_QoITimelinessAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._QoITimelinessAttr]);
		QoIFormatAttr= new MemberElement_QoIFormatAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_QoIBaseAttrType._QoIFormatAttr]);
	}
	// Attributes
	public MemberAttribute_name name;
		public static class MemberAttribute_name
		{
			private com.altova.xml.TypeBase owner;
			private com.altova.typeinfo.MemberInfo info; 
			public MemberAttribute_name (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) {this.owner = owner; this.info = info;}
			public String getValue() {
				return (String)com.altova.xml.XmlTreeOperations.castToString(com.altova.xml.XmlTreeOperations.findAttribute(owner.getNode(), info), info);
			}
			public void setValue(String value) {
				com.altova.xml.XmlTreeOperations.setValue(owner.getNode(), info, value);		
			}
			public boolean exists() {return owner.getAttribute(info) != null;}
			public void remove() {owner.removeAttribute(info);} 
			public com.altova.xml.meta.Attribute getInfo() {return new com.altova.xml.meta.Attribute(info);}

		}
	public MemberAttribute_id id;
		public static class MemberAttribute_id
		{
			private com.altova.xml.TypeBase owner;
			private com.altova.typeinfo.MemberInfo info; 
			public MemberAttribute_id (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) {this.owner = owner; this.info = info;}
			public String getValue() {
				return (String)com.altova.xml.XmlTreeOperations.castToString(com.altova.xml.XmlTreeOperations.findAttribute(owner.getNode(), info), info);
			}
			public void setValue(String value) {
				com.altova.xml.XmlTreeOperations.setValue(owner.getNode(), info, value);		
			}
			public boolean exists() {return owner.getAttribute(info) != null;}
			public void remove() {owner.removeAttribute(info);} 
			public com.altova.xml.meta.Attribute getInfo() {return new com.altova.xml.meta.Attribute(info);}

		}


	// Elements
	
	public MemberElement_QoIIntegrityAttr QoIIntegrityAttr;

		public static class MemberElement_QoIIntegrityAttr
		{
			public static class MemberElement_QoIIntegrityAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_QoIIntegrityAttr member;
				public MemberElement_QoIIntegrityAttr_Iterator(MemberElement_QoIIntegrityAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
				public boolean hasNext() 
				{
					while (nextNode != null)
					{
						if (com.altova.xml.TypeBase.memberEqualsNode(member.info, nextNode))
							return true;
						nextNode = nextNode.getNextSibling();
					}
					return false;
				}
				
				public Object next()
				{
					QoIIntegrityAttrType nx = new QoIIntegrityAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_QoIIntegrityAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public QoIIntegrityAttrType at(int index) {return new QoIIntegrityAttrType(owner.getElementAt(info, index));}
			public QoIIntegrityAttrType first() {return new QoIIntegrityAttrType(owner.getElementFirst(info));}
			public QoIIntegrityAttrType last(){return new QoIIntegrityAttrType(owner.getElementLast(info));}
			public QoIIntegrityAttrType append(){return new QoIIntegrityAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_QoIIntegrityAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
	
	public MemberElement_QoIAccuracyAttr QoIAccuracyAttr;

		public static class MemberElement_QoIAccuracyAttr
		{
			public static class MemberElement_QoIAccuracyAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_QoIAccuracyAttr member;
				public MemberElement_QoIAccuracyAttr_Iterator(MemberElement_QoIAccuracyAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
				public boolean hasNext() 
				{
					while (nextNode != null)
					{
						if (com.altova.xml.TypeBase.memberEqualsNode(member.info, nextNode))
							return true;
						nextNode = nextNode.getNextSibling();
					}
					return false;
				}
				
				public Object next()
				{
					QoIAccuracyAttrType nx = new QoIAccuracyAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_QoIAccuracyAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public QoIAccuracyAttrType at(int index) {return new QoIAccuracyAttrType(owner.getElementAt(info, index));}
			public QoIAccuracyAttrType first() {return new QoIAccuracyAttrType(owner.getElementFirst(info));}
			public QoIAccuracyAttrType last(){return new QoIAccuracyAttrType(owner.getElementLast(info));}
			public QoIAccuracyAttrType append(){return new QoIAccuracyAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_QoIAccuracyAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
	
	public MemberElement_QoITimelinessAttr QoITimelinessAttr;

		public static class MemberElement_QoITimelinessAttr
		{
			public static class MemberElement_QoITimelinessAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_QoITimelinessAttr member;
				public MemberElement_QoITimelinessAttr_Iterator(MemberElement_QoITimelinessAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
				public boolean hasNext() 
				{
					while (nextNode != null)
					{
						if (com.altova.xml.TypeBase.memberEqualsNode(member.info, nextNode))
							return true;
						nextNode = nextNode.getNextSibling();
					}
					return false;
				}
				
				public Object next()
				{
					QoITimelinessAttrType nx = new QoITimelinessAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_QoITimelinessAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public QoITimelinessAttrType at(int index) {return new QoITimelinessAttrType(owner.getElementAt(info, index));}
			public QoITimelinessAttrType first() {return new QoITimelinessAttrType(owner.getElementFirst(info));}
			public QoITimelinessAttrType last(){return new QoITimelinessAttrType(owner.getElementLast(info));}
			public QoITimelinessAttrType append(){return new QoITimelinessAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_QoITimelinessAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
	
	public MemberElement_QoIFormatAttr QoIFormatAttr;

		public static class MemberElement_QoIFormatAttr
		{
			public static class MemberElement_QoIFormatAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_QoIFormatAttr member;
				public MemberElement_QoIFormatAttr_Iterator(MemberElement_QoIFormatAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
				public boolean hasNext() 
				{
					while (nextNode != null)
					{
						if (com.altova.xml.TypeBase.memberEqualsNode(member.info, nextNode))
							return true;
						nextNode = nextNode.getNextSibling();
					}
					return false;
				}
				
				public Object next()
				{
					QoIFormatAttrType nx = new QoIFormatAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_QoIFormatAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public QoIFormatAttrType at(int index) {return new QoIFormatAttrType(owner.getElementAt(info, index));}
			public QoIFormatAttrType first() {return new QoIFormatAttrType(owner.getElementFirst(info));}
			public QoIFormatAttrType last(){return new QoIFormatAttrType(owner.getElementLast(info));}
			public QoIFormatAttrType append(){return new QoIFormatAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_QoIFormatAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
}