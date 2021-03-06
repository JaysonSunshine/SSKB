////////////////////////////////////////////////////////////////////////
//
// VoIBaseAttrType.java
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

public class VoIBaseAttrType extends com.altova.xml.TypeBase
{
	public static com.altova.xml.meta.ComplexType getStaticInfo() { return new com.altova.xml.meta.ComplexType(com.MetaData.MetaData_TypeInfo.binder.getTypes()[com.MetaData.MetaData_TypeInfo._altova_ti_altova_VoIBaseAttrType]); }
	
	public VoIBaseAttrType(org.w3c.dom.Node init)
	{
		super(init);
		instantiateMembers();
	}

	private void instantiateMembers()
	{
		name = new MemberAttribute_name (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_VoIBaseAttrType._name]);
		id = new MemberAttribute_id (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_VoIBaseAttrType._id]);

		VoIUsefulnessAttr= new MemberElement_VoIUsefulnessAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_VoIBaseAttrType._VoIUsefulnessAttr]);
		VoITrustAttr= new MemberElement_VoITrustAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_VoIBaseAttrType._VoITrustAttr]);
		VoIConvenienceAttr= new MemberElement_VoIConvenienceAttr (this, com.MetaData.MetaData_TypeInfo.binder.getMembers()[com.MetaData.MetaData_TypeInfo._altova_mi_altova_VoIBaseAttrType._VoIConvenienceAttr]);
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
	
	public MemberElement_VoIUsefulnessAttr VoIUsefulnessAttr;

		public static class MemberElement_VoIUsefulnessAttr
		{
			public static class MemberElement_VoIUsefulnessAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_VoIUsefulnessAttr member;
				public MemberElement_VoIUsefulnessAttr_Iterator(MemberElement_VoIUsefulnessAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
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
					VoIUsefulnessAttrType nx = new VoIUsefulnessAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_VoIUsefulnessAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public VoIUsefulnessAttrType at(int index) {return new VoIUsefulnessAttrType(owner.getElementAt(info, index));}
			public VoIUsefulnessAttrType first() {return new VoIUsefulnessAttrType(owner.getElementFirst(info));}
			public VoIUsefulnessAttrType last(){return new VoIUsefulnessAttrType(owner.getElementLast(info));}
			public VoIUsefulnessAttrType append(){return new VoIUsefulnessAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_VoIUsefulnessAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
	
	public MemberElement_VoITrustAttr VoITrustAttr;

		public static class MemberElement_VoITrustAttr
		{
			public static class MemberElement_VoITrustAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_VoITrustAttr member;
				public MemberElement_VoITrustAttr_Iterator(MemberElement_VoITrustAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
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
					VoITrustAttrType nx = new VoITrustAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_VoITrustAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public VoITrustAttrType at(int index) {return new VoITrustAttrType(owner.getElementAt(info, index));}
			public VoITrustAttrType first() {return new VoITrustAttrType(owner.getElementFirst(info));}
			public VoITrustAttrType last(){return new VoITrustAttrType(owner.getElementLast(info));}
			public VoITrustAttrType append(){return new VoITrustAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_VoITrustAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
	
	public MemberElement_VoIConvenienceAttr VoIConvenienceAttr;

		public static class MemberElement_VoIConvenienceAttr
		{
			public static class MemberElement_VoIConvenienceAttr_Iterator implements java.util.Iterator
			{
				private org.w3c.dom.Node nextNode;
				private MemberElement_VoIConvenienceAttr member;
				public MemberElement_VoIConvenienceAttr_Iterator(MemberElement_VoIConvenienceAttr member) {this.member=member; nextNode=member.owner.getElementFirst(member.info);}
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
					VoIConvenienceAttrType nx = new VoIConvenienceAttrType(nextNode);
					nextNode = nextNode.getNextSibling();
					return nx;
				}
				
				public void remove () {}
			}
			protected com.altova.xml.TypeBase owner;
			protected com.altova.typeinfo.MemberInfo info;
			public MemberElement_VoIConvenienceAttr (com.altova.xml.TypeBase owner, com.altova.typeinfo.MemberInfo info) { this.owner = owner; this.info = info;}
			public VoIConvenienceAttrType at(int index) {return new VoIConvenienceAttrType(owner.getElementAt(info, index));}
			public VoIConvenienceAttrType first() {return new VoIConvenienceAttrType(owner.getElementFirst(info));}
			public VoIConvenienceAttrType last(){return new VoIConvenienceAttrType(owner.getElementLast(info));}
			public VoIConvenienceAttrType append(){return new VoIConvenienceAttrType(owner.createElement(info));}
			public boolean exists() {return count() > 0;}
			public int count() {return owner.countElement(info);}
			public void remove() {owner.removeElement(info);}
			public void removeAt(int index) {owner.removeElementAt(info, index);}
			public java.util.Iterator iterator() {return new MemberElement_VoIConvenienceAttr_Iterator(this);}
			public com.altova.xml.meta.Element getInfo() { return new com.altova.xml.meta.Element(info); }
		}
}
