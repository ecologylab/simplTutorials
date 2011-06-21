//
//  Entity.h
//  ecologylabXML
//
//  Generated by CocoaTranslator on 06/21/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import <Foundation/Foundation.h>
#import "ElementState.h"


/*!
	@class		Entity
	@abstract	This class is generated by CocoaTranslator. 
	@discussion	missing java doc comments or could not find the source file.
*/
@interface Entity : ElementState
{
	/*!
		@var		m_id
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	NSString *m_id;

	/*!
		@var		online
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	bool online;

	/*!
		@var		m_in
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	bool m_in;

	/*!
		@var		safe
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	bool safe;

	/*!
		@var		ord
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int ord;

}

@property (nonatomic, readwrite, retain) NSString *m_id;
@property (nonatomic, readwrite) bool online;
@property (nonatomic, readwrite) bool m_in;
@property (nonatomic, readwrite) bool safe;
@property (nonatomic, readwrite) int ord;

- (void) setOnlineWithReference: (bool *) p_online;
- (void) setM_inWithReference: (bool *) p_m_in;
- (void) setSafeWithReference: (bool *) p_safe;
- (void) setOrdWithReference: (int *) p_ord;

@end

