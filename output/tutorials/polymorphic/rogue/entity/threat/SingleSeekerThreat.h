//
//  SingleSeekerThreat.h
//  ecologylabXML
//
//  Generated by CocoaTranslator on 06/21/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import <Foundation/Foundation.h>
#import "Threat.h"


/*!
	@class		SingleSeekerThreat
	@abstract	This class is generated by CocoaTranslator. Annotated as: 
				@simpl_inherit
				@xml_tag
	@discussion	missing java doc comments or could not find the source file.
*/
@interface SingleSeekerThreat : Threat
{
	/*!
		@var		targetOrd
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int targetOrd;

}

@property (nonatomic, readwrite) int targetOrd;

- (void) setTargetOrdWithReference: (int *) p_targetOrd;

@end

